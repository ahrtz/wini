[TOC]

# 3. REVIEW



## 3.1 리뷰 작성 POST /review/register

`Request parameters`

| Parameter | Type    | Description   |
| --------- | ------- | ------------- |
| title     | String  | 리뷰 제목     |
| content   | String  | 리뷰 내용     |
| rating    | String  | 별점          |
| userid    | String  | 사용자 아이디 |
| winename  | String  | 와인 이름     |
| wid       | Integer | 와인 번호     |

`Response (Success)`

| Field   | Type    | Description |
| ------- | ------- | ----------- |
| success | Stringh | 성공        |



## 3.2 리뷰 조회 POST /review/getbyid

`Request parameters`

| Field   | Type    | Description |
| ------- | ------- | ----------- |
| userid | Stringh | 사용자 아이디        |

`Response (Success)`

| Parameter | Type   | Description   |
| --------- | ------ | ------------- |
| rid     | int | 리뷰 고유번호     |
| title     | String | 리뷰 제목     |
| content   | String | 리뷰 내용     |
| rating    | String | 별점          |
| winename  | String | 와인 이름     |
| userid    | String | 사용자 아이디 |
| date    | String | 작성날짜(YYYY.MM.dd-HH.mm) |



## 3.3 리뷰 수정 POST /review/update

`Request parameters`

| Parameter | Type   | Description   |
| --------- | ------ | ------------- |
| rid     | int | 리뷰 고유번호     |
| title     | String | 리뷰 제목     |
| content   | String | 리뷰 내용     |
| rating    | String | 별점          |
| winename  | String | 와인 이름     |
| userid    | String | 사용자 아이디 |

`Response (Success)`

| Field   | Type    | Description |
| ------- | ------- | ----------- |
| success | Stringh | 성공        |



## 3.4 리뷰 삭제 POST /review/delete

`Request parameters`

| Parameter | Type   | Description   |
| --------- | ------ | ------------- |
| rid     | int | 리뷰 고유번호     |

`Response (Success)`

| Field   | Type    | Description |
| ------- | ------- | ----------- |
| success | Stringh | 성공        |

