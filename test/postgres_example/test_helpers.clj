(ns postgres-example.test-helpers
  (:require [clojure.java.jdbc :as jdbc]
            [environ.core :refer [env]]
            [postgres-example.components.postgres :as postgres]))

(def ^:dynamic store nil)

(def test-db-uri (str (:database-url env) "_test"))

(defn db-transaction-fixture [f]
  (jdbc/with-db-transaction [conn test-db-uri]
    (jdbc/db-set-rollback-only! conn)
    (binding [store (postgres/build conn)]
      (f))))
