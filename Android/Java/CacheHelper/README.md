# CacheHelper
This class can be used as creating cache for OkHttpClient object;

## Usage
```java
OkHttpClient client = new OkHttpClient.Builder()
	.cache(CacheHelper.getCache(c))
	.build();
```