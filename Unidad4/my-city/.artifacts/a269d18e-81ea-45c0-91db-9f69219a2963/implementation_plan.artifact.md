# Implementation Plan - My City App (Bogotá)

This plan outlines the steps to build the "My City" app, a recommendation guide for Bogotá, Colombia. The app will feature categories like Coffee Shops, Restaurants, Kids' places, Parks, and Malls. It will follow MVVM architecture, use Jetpack Compose, Navigation, and Adaptive Layouts.

## User Review Required

> [!IMPORTANT]
> The app will be customized for **Bogotá**. I will add specific place names and descriptions in the `strings.xml` file.

## Proposed Changes

### Data Layer

#### [MODIFY] [RecommendedPlace.kt](file:///D:/CURSOS/desarrollo_movil/Kotlin/Unidad4/my-city/app/src/main/java/com/example/mycity/model/RecommendedPlace.kt)
- Update `Category` enum to include string resource IDs for names.
- Ensure `RecommendedPlace` model is robust.

#### [MODIFY] [strings.xml](file:///D:/CURSOS/desarrollo_movil/Kotlin/Unidad4/my-city/app/src/main/res/values/strings.xml)
- Add string resources for categories and 15 recommended places (3 per category) including titles and descriptions.

#### [MODIFY] [RecommendedPlaceDataProvider.kt](file:///D:/CURSOS/desarrollo_movil/Kotlin/Unidad4/my-city/app/src/main/java/com/example/mycity/data/RecommendedPlaceDataProvider.kt)
- Populate with data for Bogotá using the added string and drawable resources.

---

### UI Layer

#### [MODIFY] [RecommendedPlaceViewModel.kt](file:///D:/CURSOS/desarrollo_movil/Kotlin/Unidad4/my-city/app/src/main/java/com/example/mycity/ui/RecommendedPlaceViewModel.kt)
- Define `RecommendedPlaceUiState` with `currentCategory`, `currentPlace`, and navigation state.
- Implement methods to update state (selection, navigation).

#### [MODIFY] [RecommendedPlaceScreens.kt](file:///D:/CURSOS/desarrollo_movil/Kotlin/Unidad4/my-city/app/src/main/java/com/example/mycity/ui/RecommendedPlaceScreens.kt)
- Implement `CategoryList`, `RecommendedPlaceList`, and `RecommendedPlaceDetail`.
- Implement `RecommendedPlaceApp` to orchestrate navigation and adaptive layouts.
- Use `WindowWidthSizeClass` to switch between single-pane and list-detail views.

#### [MODIFY] [MainActivity.kt](file:///D:/CURSOS/desarrollo_movil/Kotlin/Unidad4/my-city/app/src/main/java/com/example/mycity/MainActivity.kt)
- Initialize `WindowSizeClass` and pass it to the main composable.

## Verification Plan

### Automated Tests
- I will verify the build using `./gradlew assembleDebug`.

### Manual Verification
- Deploy to an emulator to verify navigation flows.
- Resize the emulator/device to verify adaptive layout (List-Detail vs. Single Pane).
- Verify Material 3 components and theming.
