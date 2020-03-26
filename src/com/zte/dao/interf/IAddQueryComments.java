package com.zte.dao.interf;

import java.util.ArrayList;

import com.zte.entity.Comment;

public interface IAddQueryComments {

	/**º”»Î¡Ù—‘
	 * @param name
	 * @param title
	 * @param content
	 */
	public void  addComments(String name ,String title,String content);
	/**≤È—Ø¡Ù—‘
	 * @return
	 */
	public ArrayList<Comment> queryComment();
}
