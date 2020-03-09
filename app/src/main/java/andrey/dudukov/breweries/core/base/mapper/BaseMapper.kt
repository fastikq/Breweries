package andrey.dudukov.breweries.core.base.mapper

interface BaseMapper<in Source, out Destination> {
    infix fun from(source: Source): Destination
}