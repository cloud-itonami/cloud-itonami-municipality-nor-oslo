(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest oslo-has-culture-basis
  (let [sb (facts/spec-basis "oslo")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "oslo" (:culture/municipality %)) sb))
    (is (every? #(= "NOR" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "bergen")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["oslo" "bergen"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["bergen"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 3 (count (facts/by-kind "oslo" :dish))))
  (is (= ["oslo.beverage.ringnes"]
         (mapv :culture/id (facts/by-kind "oslo" :beverage))))
  (is (empty? (facts/by-kind "oslo" :craft)))
  (is (empty? (facts/by-kind "bergen" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
