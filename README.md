# Spring 5 + Retrofit

 `spring-with-retrofit`은 Spring 5에서 `Retrofit`을 사용하는 예제 프로젝트입니다.
 
## Retrofit이란?

`Retrofit`은 Square사에서 만든 HTTP 클라이언트 라이브러리로써,
REST API를 호출하기 위한 라이브러리입니다.
`Retrofit`은 `OkHttp`를 기반으로 만들어졌으며,
인터페이스를 통해 REST API를 호출할 수 있습니다.

## 왜 Retrofit을 사용할까?

`Retrofit`은 인터페이스를 통해 REST API를 호출하기 때문에,
REST API를 호출하는 코드를 간결하게 작성할 수 있습니다.

이는 `Spring`에서 `RestTemplate`을 사용하는 것보다 코드가 간결해지고,
가독성이 좋아집니다.

`Retrofit`을 사용하는 경우:

```kotlin
interface GitHubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repo>>
}

val gitHubService = Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(GitHubService::class.java)

val response: List<Repo> = gitHubService.listRepos("HarryJhin").execute().body()
```

`RestTemplate`을 사용하는 경우:

```kotlin
val restTemplate = RestTemplate()
val response = restTemplate.exchange(
    "https://api.github.com/users/{user}/repos",
    HttpMethod.GET,
    null,
    object : ParameterizedTypeReference<List<Repo>>() {},
    user
)
```

## Spring 6에서는?

`Spring 6`부터 `Retrofit`과 유사하게 인터페이스를 통해 REST API를 호출할 수 있는 [`@HttpExchange`](https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#rest-http-interface)를 제공합니다.
