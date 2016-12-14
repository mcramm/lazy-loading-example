# postgres-example

**WARNING!**

**This is a work in progress.**

A simple example showing off some patterns for accessing a postgres instance
from Clojure.

## Usage

Clone this repo.

Make a database, export a DATABASE_URL variable, then launch a
repl. Something like:

```
    $ DATABASE_URL=postgresql://postgres_example:secret@localhost:5432/postgres_example lein repl
```
Note that the above should work provided you've created a database and user
called "postgres_example", with the password "secret".

Once the repl has launched, you should be able to run `(migrate)` to set up the
database. You can follow along at [https://mcramm.com](http://mcramm.com/post/off-the-ground-with-clojure-and-postgres/).

## License

Copyright © 2016 G. Michael Cramm

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
