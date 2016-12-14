(ns user
  (:require [ragtime.repl]
            [ragtime.jdbc]
            [environ.core :refer [env]]
            [postgres-example.components.postgres :as postgres]
            ))

(def config
  {:datastore (ragtime.jdbc/sql-database (env :database-url))
   :migrations (ragtime.jdbc/load-resources "migrations")})

(def test-config
  {:datastore (ragtime.jdbc/sql-database (str (env :database-url) "_test"))
   :migrations (ragtime.jdbc/load-resources "migrations")})

(defn migrate []
  (ragtime.repl/migrate config)
  (ragtime.repl/migrate test-config))

(defn rollback []
  (ragtime.repl/rollback config)
  (ragtime.repl/rollback test-config))

(defn create-store []
  (postgres/build (env :database-url)))
