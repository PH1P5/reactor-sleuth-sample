package de.phitho.sample.web

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux

import java.util.*

@RestController
class SampleController {

	@GetMapping("/sample")
	fun getSample(): Mono<ResponseEntity<List<String>>> {
		return Mono.just(ResponseEntity.ok(listOf("this", "works")))
	}

	@GetMapping("/samples")
	fun getSamples(): Flux<String> {
		return Flux.fromIterable(listOf("no","way"))
	}
}
