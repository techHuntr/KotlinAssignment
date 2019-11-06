package com.ewind.assessment.domain.usecase

import com.ewind.assessment.domain.repository.WorkRepository

class WorkUseCase(val workRepository: WorkRepository) {
    fun getWorks(dates: String) = workRepository.getWorks(dates)
}