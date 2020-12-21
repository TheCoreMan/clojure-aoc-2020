(ns clojure-aoc-2020.day1
  (:require
   [clojure.string :as str]))

(println "day1")

;; Defined a variable - scope is namespace
(def target 2020)

;; Read a file (slurp)
;; split lines - obvious, but search in cheat sheet
;; needed to require and alias. also, . is with / for namespaces (a-la RDF). looks neat
;; map to read-string which parses int
;; used set constructor
;; used the ->> syntax - macro sugar to avoid lisp hell. thread last. put (peek expr) as (last nextexpr).
;; , d v e - debug -> inspect value -> here.
;; , e b - run the buffer (file)
(def bag-o-numbers
  (->> "resources/1.txt"
       slurp
       str/split-lines
       (map read-string)
       set))

;; Some algo, not too hard
;; some is cool, based on false-y nils
;; fn is lambda
;; if syntax: if (predicate) (do-if-true) (optional do-otherwise || nil)
(defn answer [target]
  (some
   (fn [x]
     (if (contains? bag-o-numbers (- target x))
       (* x (- target x))))
   bag-o-numbers))

;; when let is comlex:
;; let - bind value to symbol in let scope: let [x 1] now x is nothing again cause we're out of scope
;; when - when true do
;; when-let - now kiss. Want to be in the room where it happens? , e m. Se  how the sausage gets made? , e M. Beware
(def three-numers-product
  (some
   (fn [x]
     (when-let [hit (answer (- target x))]
       (* x hit)))
   bag-o-numbers))

(println :done)

