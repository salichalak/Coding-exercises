SELECT rw.id, rw.content, rw.rating, rw.picture_url, rw.published_at
FROM reviews AS rw
WHERE rw.content LIKE 'My%' AND CHAR_LENGTH(rw.content) > 61
ORDER BY rw.rating DESC;