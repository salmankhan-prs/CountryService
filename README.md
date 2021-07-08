
# Country API
Basic API which have all Crud operations.

## API Reference

#### Get all Countries

```http
  GET /api/v1/countries
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `NONE` |  |for fetching All Countries present in Database|

#### Get country with countryId

```http
  GET /api/v1/countries/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | for fetching country with countryId |


  #### Get country with countryId

```http
  GET /api/v1/countries/{code}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `code`      | `string` | for fetching country with code |

 #### Get country with countryId

```http
  GET /api/v1/countries/{name}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `string` | for fetching country with name |



 #### To save Single country 

```http
  POST /api/v1/countries
```

| Parameter | Type     | 
| :-------- | :------- | 
| `code`      | `string` |
| `name`      | `string` |


#### To update country which is alredy existed in database

```http
  PUT /api/v1/countries
```


```http
  DELETE /api/v1/countries/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | for deleting country with id |


## Authors

- [@salman khan](https://github.com/salmankhan-prs)

  
## Screenshots

![App Screenshot](https://i.ibb.co/3yz7ZGZ/Screenshot-586.png)

![App Screenshot](https://i.ibb.co/f1fdr78/Screenshot-587.png)

![App Screenshot](https://i.ibb.co/TqHzStC/Screenshot-589.png" )

  