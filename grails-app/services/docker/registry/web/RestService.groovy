package docker.registry.web

import grails.plugins.rest.client.RestBuilder
import org.springframework.beans.factory.annotation.Value

class RestService {
  @Value('${registry.url}')
  String registryUrl

  def get(String path) {
    def rest = new RestBuilder()
    rest.get("${registryUrl}/${path}").json
  }

  def headLength(String path) {
    def rest = new RestBuilder()
    def res = rest.head("${registryUrl}/${path}")
    def size = res.responseEntity.headers.getFirst('Content-Length')
    size as BigDecimal
  }
}