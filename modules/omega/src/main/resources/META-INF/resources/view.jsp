<%@ include file="/init.jsp" %>

<div id="foo" data-foo="${configuration.foo()}"></div>

<div id="omega-app" data-namespace="<portlet:namespace/>"></div>

<script crossorigin src="https://unpkg.com/react@17/umd/react.production.min.js"></script>
<script crossorigin src="https://unpkg.com/react-dom@17/umd/react-dom.production.min.js"></script>
<script src="/o/omega-app/dist/engine.js"></script>
<script src="/o/omega-app/dist/ui.js"></script>
<script src="/o/omega-app/dist/vendor.js"></script>
<script src="/o/omega-app/dist/runtime.js"></script>
<script src="/o/omega-app/dist/main.js"></script>