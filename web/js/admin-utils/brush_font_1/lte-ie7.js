/* Load this script using conditional IE comments if you need to support IE 7 and IE 6. */

window.onload = function() {
	function addIcon(el, entity) {
		var html = el.innerHTML;
		el.innerHTML = '<span style="font-family: \'brush_font_1\'">' + entity + '</span>' + html;
	}
	var icons = {
			'icn_home' : '&#x21;',
			'icn_pencil' : '&#x27;',
			'icn_pencil-2' : '&#x26;',
			'icn_quill' : '&#x28;',
			'icn_image' : '&#x2d;',
			'icn_images' : '&#x2f;',
			'icn_camera' : '&#x30;',
			'icn_books' : '&#x41;',
			'icn_zoom-in' : '&#xe022;',
			'icn_search' : '&#xe021;',
			'icn_zoom-out' : '&#xe023;',
			'icn_wrench' : '&#xe02d;',
			'icn_cogs' : '&#xe031;',
			'icn_cog' : '&#xe032;',
			'icn_hammer' : '&#xe033;',
			'icn_wand' : '&#xe034;',
			'icn_remove' : '&#xe049;',
			'icn_box-add' : '&#x7d;',
			'icn_briefcase' : '&#xe04b;',
			'icn_airplane' : '&#x7a;',
			'icn_close' : '&#xe09f;',
			'icn_plus' : '&#xe0a4;',
			'icn_minus' : '&#xe0a3;',
			'icn_crop' : '&#xe0df;',
			'icn_scissors' : '&#xe0e0;',
			'icn_blogger' : '&#xe132;',
			'icn_tux' : '&#xe137;',
			'icn_android' : '&#xe13a;'
		},
		els = document.getElementsByTagName('*'),
		i, attr, html, c, el;
	for (i = 0; i < els.length; i += 1) {
		el = els[i];
		attr = el.getAttribute('data-icon');
		if (attr) {
			addIcon(el, attr);
		}
		c = el.className;
		c = c.match(/icn_[^\s'"]+/);
		if (c && icons[c[0]]) {
			addIcon(el, icons[c[0]]);
		}
	}
};