(ns postgres-example.entities.accounts
  (:require [clj-time.jdbc]

            [postgres-example.sql :as sql]
            [postgres-example.components.postgres])
  (:import [postgres_example.components.postgres Postgres]))


(defprotocol AccountOps
  (by-id [this id])
  (create! [this status])
  (update! [this account]))

(defn sql->account [sql-entity]
  (when (:id sql-entity)
    #:account {:id (:id sql-entity)
               :status (:status sql-entity)
               :created-at (:created_at sql-entity)
               :updated-at (:updated_at sql-entity)}))

(extend-protocol AccountOps
  Postgres
  (by-id [store id]
    (-> (sql/account-by-id (:uri store) {:id id})
        sql->account))

  (create! [store status]
    (let [result (sql/insert-account! (:uri store) {:status status})]
      (by-id store (:id result))))

  (update! [store account]
    (sql/update-account! (:uri store) {:id (:account/id account)
                                       :status (:account/status account)})
    (by-id store (:account/id account))))
