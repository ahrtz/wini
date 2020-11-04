[TOC]

# 1. USER

# 2.WINE

## 2.1 키워드 검색 (get/search/)

| Parameter | Type   | Description                    |
| --------- | ------ | ------------------------------ |
| keyword   | String | 검색어 (null일 경우 전체 검색) |
| page      | String | 페이지 (null일 경우 0페이지)   |

## 2.2 상세 검색(당도,산도,온도) - (post/search/)

## 2.3 상세 정보 (get/search/detail)

## 2.4 자동 완성 (get/search/auto)



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
