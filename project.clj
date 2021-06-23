(defproject pro.juxt.clojars-mirrors.clj-commons/potemkin "0.4.5"
  :license {:name "MIT License"}
  :description "Some useful facades (mirrored from Clojars by JUXT)"
  :url "https://github.com/clj-commons/potemkin"
  :scm {:name "git"
        :url "https://github.com/juxt/potemkin"
        :dir "."}
  :dependencies [[pro.juxt.clojars-mirrors.ztellman/clj-tuple "0.2.2"]
                 [pro.juxt.clojars-mirrors.ztellman/riddley "0.2.0"]]
  :profiles {:dev {:dependencies [[criterium "0.4.3"]
                                  [collection-check "0.1.6"]]}
             :provided {:dependencies [[org.clojure/clojure "1.8.0-RC4"]]}}
  :global-vars {*warn-on-reflection* true}
  :test-selectors {:default #(not (some #{:benchmark}
                                        (cons (:tag %) (keys %))))
                   :benchmark :benchmark
                   :all (constantly true)}
  :java-source-paths ["src"]
  :jvm-opts ^:replace ["-server" "-Xmx4g"]
  :javac-options ["-source" "1.6" "-target" "1.6"]
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}

  ;; empty JARs to keep Maven Central happy
  :classifiers {:sources {:jar-exclusions [#""]}
                :javadoc {:jar-exclusions [#""]}}

  :pom-addition ([:developers
                  [:developer
                   [:id "ztellman"]
                   [:name "Zach Tellman"]]
                  [:developer
                   [:id "juxt"]
                   [:name "JUXT"]
                   [:roles [:role "packager"]]]])

  :deploy-repositories {"releases" {:url "https://oss.sonatype.org/service/local/staging/deploy/maven2"
                                    :creds :gpg}
                        "snapshots" {:url "https://oss.sonatype.org/content/repositories/snapshots"
                                     :creds :gpg}})
