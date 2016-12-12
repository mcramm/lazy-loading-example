(ns user
  (:require [ragtime.repl]
            [ragtime.jdbc]
            [environ.core :refer [env]]
            [postgres-example.components.postgres :as postgres]
            ))

(def config
  {:datastore (ragtime.jdbc/sql-database (env :database-url))
   :migrations (ragtime.jdbc/load-resources "migrations")})

(defn migrate []
  (ragtime.repl/migrate config))

(defn rollback []
  (ragtime.repl/rollback config))

(defn create-store []
  (postgres/build (env :database-url)))
