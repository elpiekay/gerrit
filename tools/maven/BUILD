load('//:version.bzl', 'GERRIT_VERSION')
load('//tools/maven:package.bzl', 'maven_package')

MAVEN_REPOSITORY = 'sonatype-nexus-staging'
# TODO(davido): support snapshot repositories
MAVEN_RELEASE_URL = 'https://oss.sonatype.org/service/local/staging/deploy/maven2'

maven_package(
  repository = MAVEN_REPOSITORY,
  url = MAVEN_RELEASE_URL,
  version = GERRIT_VERSION,
  jar = {
    'gerrit-acceptance-framework': '//gerrit-acceptance-framework:acceptance-framework_deploy.jar',
    'gerrit-extension-api': '//gerrit-extension-api:extension-api_deploy.jar',
    'gerrit-plugin-api': '//gerrit-plugin-api:plugin-api_deploy.jar',
    'gerrit-plugin-gwtui': '//gerrit-plugin-gwtui:gwtui-api_deploy.jar',
  },
  src = {
    'gerrit-acceptance-framework': '//gerrit-acceptance-framework:liblib-src.jar',
    'gerrit-extension-api': '//gerrit-extension-api:libapi-src.jar',
    'gerrit-plugin-api': '//gerrit-plugin-api:plugin-api-sources_deploy.jar',
    'gerrit-plugin-gwtui': '//gerrit-plugin-gwtui:gwtui-api-source_deploy.jar',
  },
  doc = {
    'gerrit-acceptance-framework': '//gerrit-acceptance-framework:acceptance-framework-javadoc',
    'gerrit-extension-api': '//gerrit-extension-api:extension-api-javadoc',
    'gerrit-plugin-api': '//gerrit-plugin-api:plugin-api-javadoc',
    'gerrit-plugin-gwtui': '//gerrit-plugin-gwtui:gwtui-api-javadoc',
  },
  war = {'gerrit-war': '//:release'},
)
