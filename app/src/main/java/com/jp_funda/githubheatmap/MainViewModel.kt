package com.jp_funda.githubheatmap

import androidx.lifecycle.ViewModel
import com.jp_funda.github_heatmap.models.GitHubHeatmapLevel
import com.jp_funda.github_heatmap.utils.DateIterator
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    val startDate: LocalDate = LocalDate.now().minusMonths(1)
    val endDate: LocalDate = LocalDate.now()

    private val dateIterator = DateIterator(
        startDate = startDate,
        endDateInclusive = LocalDate.now(),
        stepDays = 1,
    )

    val randomDateLevelMap: Map<LocalDate, GitHubHeatmapLevel>
        get() {
            val map = mutableMapOf<LocalDate, GitHubHeatmapLevel>()
            for (localDate in dateIterator) {
                if (Random.nextBoolean()) {
                    val level = GitHubHeatmapLevel.values().random()
                    map[localDate] = level
                }
            }
            return map
        }
}