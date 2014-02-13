(defproject compojure-rest "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [ring/ring-jetty-adapter "1.2.0"]
                 [ring-middleware-format "0.3.0"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler compojure-rest.handler/app}
  :main compojure-rest.handler
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
