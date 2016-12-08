-- :name account-by-id :? :1
-- :doc Get an account by id
SELECT *
FROM accounts
WHERE id = :id

-- :name insert-account! :< :1
-- :doc Inserts an account and returns the id
INSERT INTO accounts (status)
VALUES (:status)
RETURNING id
