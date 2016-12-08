(ns lazy-loading-example.entities.accounts
  (:require [clj-time.jdbc]

            [lazy-loading-example.sql :as sql]
            [lazy-loading-example.components.postgres])
  (:import [lazy_loading_example.components.postgres Postgres]))


(defprotocol AccountOps
  (by-id [this id])
  (create! [this status])
  (update! [this status]))

(defn sql->account [sql-entitiy])

(extend-protocol AccountOps
  Postgres
  (by-id [store id]
    (sql/account-by-id (:uri store) {:id id}))
  (create! [store status]
    (let [result (sql/insert-account! (:uri store) {:status status})]
      (by-id store (:id result)))))