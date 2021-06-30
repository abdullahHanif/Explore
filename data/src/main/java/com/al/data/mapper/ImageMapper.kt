package com.al.data.mapper


import com.al.data.model.Image
import com.al.domain.entity.ImageEntity

object ImageMapper : Mapper<ImageEntity, Image> {

    override fun fromDataToDomainType(from: Image): ImageEntity =
        ImageEntity(
            from.id,
            from.largeImageURL,
            from.user,
            from.userImageURL,
            from.previewURL,
            from.tags
        )


    override fun fromDomainToDataType(to: ImageEntity): Image =
        Image(
            to.id,
            to.largeImageURL,
            to.user,
            to.userImageURL,
            to.previewURL,
            to.tags
        )
}