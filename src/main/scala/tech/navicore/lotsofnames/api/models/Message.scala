package tech.navicore.lotsofnames.api.models

import java.util.{Date, UUID}

final case class Name (
    id: UUID,
    datetime: Date,
    sourceId: String,
    name: String
)

final case class Query(sourceId: String)
