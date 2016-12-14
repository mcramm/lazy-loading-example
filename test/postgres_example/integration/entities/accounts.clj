(ns postgres-example.integration.entities.accounts
  (:require [clojure.test :refer :all]
            [postgres-example.test-helpers :refer [store db-transaction-fixture]]
            [postgres-example.entities.accounts :refer :all]))

(use-fixtures :each db-transaction-fixture)

(deftest create!-test
  (testing "create! creates and returns an account"
    (let [account (create! store "open")]
      (is (not (nil? (:account/id account))))
      (is (= "open" (:account/status account))))))

(deftest by-id-test
  (testing "by-id returns the correct account by id"
    (let [account (create! store "open")]
      (is (= account
             (by-id store (:account/id account)))))))

(deftest set-opened!-test
  (testing "set-opened! sets an account's status to opened-status"
    (let [account (create! store "closed")]
      (set-opened! store account)
      (is (= opened-status
             (:account/status (by-id store (:account/id account))))))))

(deftest set-closed!-test
  (testing "set-closed! sets an account's status to closed-status"
    (let [account (create! store "open")]
      (set-closed! store account)
      (is (= closed-status
             (:account/status (by-id store (:account/id account))))))))
