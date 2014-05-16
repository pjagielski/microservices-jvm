(ns compojure-rest.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]
            [ring.util.response :refer [resource-response response status]]
            [ring.adapter.jetty :refer (run-jetty)])
  (:gen-class))

(def messages (atom {}))

(defn get-message [name]
  (get (deref messages) name))

(defn put-message [name message]
  (swap! messages assoc name message))

(defroutes app-routes
  (GET "/messages/:name" [name]
       (response (get-message name)))

  (POST "/messages" {message :body}
        (let [name (:name message)]
          (put-message name message)
          (status (response "") 204)))

  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-body {:keywords? true})
      (middleware/wrap-json-response)))

(defn -main [& args]
  (run-jetty app {:port 3000 :join? false }))
