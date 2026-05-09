# Coin App - Clean Architecture (MVVM & MVI)

A sample Android application built using:

- Kotlin
- Jetpack Compose
- Clean Architecture
- Hilt Dependency Injection
- Retrofit + OkHttp
- Coroutines + StateFlow

The project demonstrates how to structure a scalable Android application for larger codebases while keeping the code testable, maintainable, and modular.

---

# 📌 Goal of this Project

This project mainly focuses on:

- Clean Architecture
- Proper layer separation
- Testability
- Scalability
- MVI vs MVVM understanding
- DTO → Domain → UI mapping
- Dependency Injection
- Modern Android development practices

🧠 MVVM vs MVI

This project explains both architectures.

# 🧠 MVVM vs MVI

This project explains both architectures.

---

## ✅ MVVM

Flow:

```text
UI → ViewModel Function → State
```

Example:

```kotlin
viewModel.loadCoins()
```

### Advantages
- Simple
- Less boilerplate
- Faster development

### Disadvantages
- Multiple state mutations
- Harder debugging in large apps
- State can become unpredictable

---

## ✅ MVI

Flow:

```text
UI → Intent → ViewModel → New State → UI
```

Example:

```kotlin
viewModel.onIntent(CoinIntent.FetchCoins)
```

### Advantages
- Unidirectional flow
- Predictable state management
- Easier debugging
- Better scalability

### Disadvantages
- More boilerplate
- Higher learning curve

---

# 📖 API Used

CoinPaprika API:

```text
https://api.coinpaprika.com/v1/coins
```

---

# 💉 Dependency Injection (Hilt)

Hilt is used for dependency management.

## Benefits

- Loose coupling
- Easier testing
- Centralized dependency graph
- Better scalability

---

# 🌐 Networking

## Networking Stack

- Retrofit
- OkHttp
- Logging Interceptor
- Header Interceptor
- Network Cache

---

# 🛠️ Features Included

- Clean Architecture
- MVI
- MVVM comparison
- Hilt
- Retrofit
- StateFlow
- Coroutines
- Compose
- DTO → Domain → UI mapping
- Testability
- Production-style network layer

---

# 🏗️ Architecture Overview

```text
Presentation Layer
       ↓
Domain Layer
       ↓
Data Layer


com.example.coins

├── data
│   ├── remote
│   │   ├── CoinApi.kt
│   │   └── dto
│   │       └── CoinDto.kt
│   │
│   ├── mapper
│   │   └── CoinMapper.kt
│   │
│   └── repository
│       └── CoinRepositoryImpl.kt
│
├── domain
│   ├── model
│   │   └── Coin.kt
│   │
│   ├── repository
│   │   └── CoinRepository.kt
│   │
│   └── usecase
│       └── CoinUseCase.kt
│
├── presentation
│   ├── coins
│   │   ├── model
│   │   │   └── CoinUiModel.kt
│   │   │
│   │   ├── mapper
│   │   │   └── CoinUiMapper.kt
│   │   │
│   │   ├── CoinIntent.kt
│   │   ├── CoinState.kt
│   │   ├── CoinViewModel.kt
│   │   └── CoinScreen.kt
│
├── di
│   └── NetworkModule.kt
