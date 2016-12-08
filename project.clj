(defproject lazy-loading-example "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                  [environ "1.1.0"]
                  [ragtime "0.6.3"]
                  [com.stuartsierra/component "0.3.1"]
                  [clj-time "0.12.2"]
                  [org.postgresql/postgresql "9.4.1207"]
                  [com.layerware/hugsql "0.4.7"]
                  [org.clojure/java.jdbc "0.6.1"]]
  :plugins [[lein-environ "1.1.0"]]
  :main ^:skip-aot lazy-loading-example.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev [:project/dev]
             :project/dev {:dependencies []
                           :resource-paths ["resources/"]
                           :source-paths ["dev"]
                           :repl-options {:init-ns user}}})
