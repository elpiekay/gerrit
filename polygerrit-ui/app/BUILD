package(
  default_visibility = ["//visibility:public"])

load('//tools/bzl:genrule2.bzl', 'genrule2')
load("//tools/bzl:js.bzl", "bower_component_bundle", "vulcanize")

bower_component_bundle(
  name = 'test_components',
  deps = [
    '//polygerrit-ui:polygerrit_components',
    '//lib/js:iron-test-helpers',
    '//lib/js:test-fixture',
    '//lib/js:web-component-tester',
  ],
)

vulcanize(
  name = "gr-app",
  app = 'elements/gr-app.html',
  srcs = glob(
  ['**/*.html', '**/*.js'],
  exclude = [
    'bower_components/**',
    'index.html',
    'test/**',
    '**/*_test.html',
    ]),
  deps = [ "//polygerrit-ui:polygerrit_components"],
)

filegroup(
  name = "top_sources",
  srcs = glob([
    'favicon.ico',
    'index.html',
  ]),
)

filegroup(
  name = "css_sources",
  srcs = glob(['styles/**/*.css'])
)

genrule2(
  name = "polygerrit_ui",
  cmd = " && ".join([
    "mkdir -p $$TMP/polygerrit_ui/{styles,fonts,bower_components/{highlightjs,webcomponentsjs},elements}",
    "cp $(locations :gr-app) $$TMP/polygerrit_ui/elements/",
    "cp $(locations //lib/fonts:sourcecodepro) $$TMP/polygerrit_ui/fonts/",
    "for f in $(locations :top_sources); do cp $$f $$TMP/polygerrit_ui/; done",
    "for f in $(locations :css_sources); do cp $$f $$TMP/polygerrit_ui/styles; done",
    "for f in $(locations //lib/js:highlightjs_files); do cp $$f $$TMP/polygerrit_ui/bower_components/highlightjs/ ; done",
    "unzip -qd $$TMP/polygerrit_ui/bower_components $(location @webcomponentsjs//:zipfile) webcomponentsjs/webcomponents-lite.js",
    "cd $$TMP",
    "find . -exec touch -t 198001010000 '{}' ';'",
    "zip -qr $$ROOT/$@ *",
  ]),
  srcs = [
    "//lib/fonts:sourcecodepro",
    "//lib/js:highlightjs_files",
    ":top_sources",
    ":css_sources",
    ":gr-app",
    # we extract from the zip, but depend on the component for license checking.
    "@webcomponentsjs//:zipfile",
    "//lib/js:webcomponentsjs",
  ],
  outs = [ "polygerrit_ui.zip" ],
)
