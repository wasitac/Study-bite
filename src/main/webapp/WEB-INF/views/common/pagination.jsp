<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<li class="page-item"><a id="pagination" class="page-link" href="/studybite/${location}page=0" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
		</a></li>
		<c:forEach var="cnt" begin="1" end="${num}" step="1">
			<li class="page-item"><a id="pagination" class="page-link" href="/studybite/${location}page=${(cnt-1) * 10}">${cnt}</a></li>
		</c:forEach>
		<li class="page-item"><a id="pagination" class="page-link" href="/studybite/${location}page=${(num-1) * 10}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
</nav>