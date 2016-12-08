(ns lazy-loading-example.sql
  (:require [hugsql.core :as hugsql]))

(hugsql/def-db-fns "sql/accounts.sql")
