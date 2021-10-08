package com.mghafori.comics.network.model

import com.mghafori.comics.model.Comic

class ComicDtoMapper {
    fun mapToDomainModel(model: ComicDto): Comic {
        return Comic(
            num = model.num,
            title = model.title,
            news = model.news,
            img = model.img,
            transcript = model.transcript,
            day = model.day,
            month = model.month,
            year = model.year,
            link = model.link,
            alt = model.alt,
            safeTitle = model.safeTitle
        )
    }
}