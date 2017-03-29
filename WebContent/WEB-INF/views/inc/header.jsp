<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<header id="header">
		<div class="content-container">
			<h1 id="logo">
				<img src="../images/logo.png" alt="뉴렉처 온라인" />
			</h1>
		
			<section>
				<h1 class="hidden">Header</h1>
			
				<nav id="main-menu" class="hr-menu">
					<h1 class="hidden">메인 메뉴</h1>
						<!-- <input type="button" value="클릭" id="btn-result"/> -->
					<ul>
						<li><a href="">학습가이드</a></li>	
						<li><a href="">뉴렉과정</a></li>
						<li><a href="">강좌선택</a></li>
					</ul>
				</nav>
			
				<nav id="lecture-search-form" class="hr-menu">
					<h1 class="hidden">강좌 검색 폼</h1>
					<form>
						<fieldset>
							<legend class="hidden">검색필드</legend>
							<label>과정검색</label>
							<input type="text"/>
							<input class="lecture-search-button" type="submit" value="검색"/>						
						</fieldset>
					</form>
				</nav>
			
				<nav id="account-menu" class="hr-menu">
					<h1 class="hidden">계정 메뉴</h1>
					<ul>
						<li><a href="../index.html">HOME</a></li>
						<li><a href="../Account/login">로그인</a></li>
						<li><a href="../Account/join">회원가입</a></li>
					</ul>
				</nav>
			
				<nav id="member-menu" class="hr-menu">	
					<h1 class="hidden">고객 메뉴</h1>
					<ul>
						<li>
							<a href="">
								<img src="../images/txt-mypage.png" alt="마이페이지" />
							</a>
						</li>
						<li>
							<a href="">
								<img src="../images/txt-customer.png" alt="고객센터" />
							</a>
						</li>
					</ul>
				</nav>
			</section>
		</div>	
	</header>