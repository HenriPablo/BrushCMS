-- SELECT

--INSERT INTO story(  title, story, date_created, last_modified, sub_title, time_created, category_id, view_link, "completion", home_page, synopsis, allow_comments, side_note, meta_description, meta_keywords )
--VALUES
--(  'some title', 'some story body', now(), now(), 'sub title ', now(), 1, 'view-link-story', true, true, 'synopsis body', true, 'some side note', 'medat description', 'meta key words'  )


-- UPDATE

/*		UPDATE story
		SET
			meta_description = 'some nice description',
			meta_keywords = 	'some keywords',
			category_id = 		1,
			title = 		'fancy title',
			story = 		'story body and stuff',
			synopsis = 		'story synopsis',
			side_note = 		'side note as well',
			date_created = 		'2010-06-26',
			last_modified = 	'2010-06-26 15:11:17',
			sub_title = 		'sub title',
			time_created = 		'2010-06-26 15:11:17',
			view_link = 		'link_to_Story_123',
			completion = 		true,
			home_page = 		true,
			allow_comments	= 	true
		WHERE
			id = 41;
*/

		UPDATE story
		SET

                title  = 'very nice article'

            WHERE
                id = 56