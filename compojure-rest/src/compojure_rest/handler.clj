(ns compojure-rest.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.format :refer :all]))

(defroutes app-routes
  (GET "/:name" [name] {:body {:message (str "Hello World" " " name)}})
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (wrap-restful-format :formats [:json-kw :edn])))
