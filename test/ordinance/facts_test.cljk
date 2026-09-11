(ns ordinance.facts-test
  (:require [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest oslo-has-spec-basis
  (let [sb (facts/spec-basis "oslo")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://www.oslo.kommune.no/") sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "stockholm")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["oslo" "stockholm"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["stockholm"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["oslo.reglement-for-bystyret"]
         (mapv :ordinance/id (facts/by-topic "oslo" :governance))))
  (is (empty? (facts/by-topic "oslo" :labor)))
  (is (empty? (facts/by-topic "stockholm" :licensing))))
