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

-- :name update-account! :< :1
-- :doc Updates an account by id
UPDATE accounts
SET status = :status,
    updated_at = now()
WHERE id = :id
RETURNING id
