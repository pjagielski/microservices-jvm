(defproject compojure-swag "0.1.0"
  :description "The swag library example project"
  :url ""
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [swag "0.2.6"]
                 [ring-middleware-format "0.3.0"]
                 [ring/ring-jetty-adapter "1.2.0"]
                 [ring "1.2.0"]
                 [compojure "1.1.5" :exclusions [ring/ring-core]]
                 [ch.qos.logback/logback-classic "1.1.0"]
                 [metrics-clojure-ring "1.0.1"]]  
  :main compojure-swag.handler)
