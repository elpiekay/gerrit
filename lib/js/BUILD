package(default_visibility = [ "//visibility:public" ])
load("//tools/bzl:js.bzl", "bower_component", "js_component")

# For updating the bower versions, run
#
#  python tools/js/bower2bazel.py -w lib/js/bower_archives.bzl -b lib/js/bower_components.bzl
#

# For adding a new component as dependency to a bower_component_bundle
#
# 1) add a new bower_archive in WORKSPACE
#
# 2) add bower_component(name="my_new_dependency", seed=True) here
#
# 3) run bower2bazel (see above.)
#
# 4) remove bower_component(name="my_new_dependency", .. ) here
#


load("//lib/js:bower_components.bzl", "define_bower_components")
define_bower_components()

js_component(
  name = 'highlightjs',
  srcs = [ "//lib/highlightjs:highlight.min.js" ],
  license = '//lib:LICENSE-highlightjs',
)

filegroup(
  name = "highlightjs_files",
  srcs = [ "//lib/highlightjs:highlight.min.js" ],
  data = ['//lib:LICENSE-highlightjs',],
)
