package com.food.domain.usecase

interface DeleteIdUseCaseInt {
   suspend  operator fun invoke(id:Int)
}