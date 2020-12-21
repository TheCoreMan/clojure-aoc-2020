(ns clojure-aoc-2020.day1
  (:require
   [clojure.string :as str]))

(println "day1")

(def target 2020)

(def bag-o-numbers
  (->> "resources/1.txt"
       slurp
       str/split-lines
       (map read-string)
       set))

(defn answer [target]
  (some
   (fn [x]
     (if (contains? bag-o-numbers (- target x))
       (* x (- target x))))
   bag-o-numbers))

(def three-numers-product
  (some
   (fn [x]
     (when-let [hit (answer (- target x))]
       (* x hit)))
   bag-o-numbers))

(println :done)

