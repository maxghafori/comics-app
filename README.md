
# Comics Application

Android Application for display Comics from https://xkcd.com
## Features

- Show current comic
- Next/Previous button
- Simple comic's detail
- Share image and title of a comic
- Favorite comic (cache a comic)


## Documentation

#### In this project :

I used Kotlin, Jetpack Compose and MVVM architecture.

#### Project structure include:

`cache`: database and query methods.

`di`: dependency injection modules.

`model`: models.

`network`: retrofit service and interactors.

`presentation`: components, navigation, them and ui.


and alson I wrote simple junit test to check getComic class that fetch data from network.




## Running Tests

To run tests, run the following command in project directory (Mac)

```bash
   ./gradlew app:test --daemon
```


## Tech Stack

Kotling, Jetpack Compose, Hilt, Retrofit, Room, Junit




## Authors

- [Mohsen Ghafori](https://www.github.com/maxghafori)

  