package com.mghafori.comics.cache.model

import com.mghafori.comics.model.Comic

class ComicEntityMapper {
    fun mapToDomainModel(model: ComicEntity): Comic {
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

    fun mapFromDomainModel(model: Comic): ComicEntity {
        return ComicEntity(
            num = model.num,
            title = model.title,
            news = model.news.toString(),
            img = model.img,
            transcript = model.transcript.toString(),
            day = model.day.toString(),
            month = model.month.toString(),
            year = model.year.toString(),
            link = model.link.toString(),
            alt = model.alt.toString(),
            safeTitle = model.safeTitle.toString()
        )
    }
}