package andrey.dudukov.breweries.entity.error.network

import andrey.dudukov.breweries.entity.error.BException

class ApiException(val errorMessage: String) : BException()