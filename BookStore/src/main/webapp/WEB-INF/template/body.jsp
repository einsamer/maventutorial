		<div class="body">
			<table class="table">
				<c:forEach items="${listbook}" var="book">
					<tr class="bookrow">
						<td>${book.bookid}<input type="hidden" class="bookimgurl"
							value="${book.bookimgurl }" />
						</td>
						<td>${book.bookauthor}</td>
						<td>${book.bookname }</td>
						<td><a href="/BookStore/book/delete/${book.bookid}">
								<button class="btn btn-info">DELETE</button>
						</a></td>
						<td><a
							href="/BookStore/book/update?id=${book.bookid}&name=${book.bookname}&author=${book.bookauthor}&url=${book.bookimgurl}">
								<button class="btn btn-info">EDIT</button>
						</a></td>
					</tr>
				</c:forEach>
			</table>
			<a href="/BookStore/book/addbook">Click here to add new one</a>

			<div class="img-container">
				<img id="img-show" alt="Default"
					src="<c:url value = '/resources/images/default.png'/>" />
			</div>
		</div>