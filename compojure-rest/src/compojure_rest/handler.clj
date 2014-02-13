(ns compojure-rest.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.format :refer :all]
            [ring.adapter.jetty :refer (run-jetty)])
  (:gen-class))

(defroutes app-routes
  (GET "/messages/:name" [name] {:body {:message (str "Hello World" " " name)}})
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (wrap-restful-format :formats [:json-kw :edn])))

(defn -main [& args]
  (run-jetty app {:port 3000 :join? false }))