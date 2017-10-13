<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="ticket_store">
    <c:forEach items="${listTicket}" var="call" varStatus="i">
        <div class="car_number">Вагон ${i.count}</div>
        <div class="car">
            <div class="in">
                <svg width="20px" height="20px" viewBox="0 0 974 974" transform="translate(4, 35)">
                    <g>
                        <path d="M205.4,421.2c-11,0-20.4,8.8-20.4,19.8v94.3c0,11,9.3,19.801,20.4,19.801h229.9L301,421.2H205.4z"
                              fill="#444"></path>
                        <polygon points="654,533.8 654,421.2 541.1,421.2" fill="#444"></polygon>
                        <path d="M758.4,421.2H681v134h77.4c11,0,19.6-8.8,19.6-19.8v-94.3C778,430,769.4,421.2,758.4,421.2z"
                              fill="#444"></path>
                        <path d="M831.4,142.6C786.7,97.9,734.6,62.8,676.6,38.3C616.5,12.9,552.7,0,487,0S357.5,12.9,297.4,38.3
		c-58,24.5-110.101,59.6-154.8,104.3c-44.7,44.7-79.8,96.8-104.3,154.8C12.9,357.5,0,421.3,0,487s12.9,129.5,38.3,189.601
		c24.5,58,59.6,110.1,104.3,154.8c44.7,44.7,96.8,79.8,154.8,104.3C357.5,961.101,421.3,974,487,974s129.5-12.899,189.6-38.3
		c58-24.5,110.101-59.6,154.801-104.3c44.699-44.7,79.8-96.8,104.3-154.8C961.1,616.5,974,552.7,974,487s-12.9-129.5-38.3-189.6
		C911.2,239.4,876.1,187.4,831.4,142.6z M487,874c-103.4,0-200.6-40.2-273.7-113.3C140.3,687.5,100,590.4,100,487
		c0-86.5,28.2-168.6,80.2-236L723,793.7C655.7,845.7,573.5,874,487,874z M793.8,723L251,180.3c67.4-52,149.5-80.3,236-80.3
		c103.4,0,200.6,40.2,273.7,113.3C833.7,286.5,874,383.6,874,487C874,573.5,845.8,655.601,793.8,723z"
                              fill="#444"></path>
                        <path d="M708.3,381.6c8.8,5.3,17.3,10.9,25.4,17.4c3.2,2.601,8,1.2,9.399-2.6c0.301-0.8,0.5-1.4,0.601-1.601
		c6.7-26.3-4.5-54.7-21.7-74.6c-17.2-20-40.6-33.6-64.8-44.1c-12.7-5.5-25.7-10.4-38.601-15.3c-12-4.5-25.699-8.4-36.699-15.1
		c-3.601-2.2-8.301,0-9,4.1c-0.101,0.5-0.2,3-0.2,4c0.5,23.2,14.6,45,30.2,61.2c15.699,16.3,34.899,28.7,54.699,39.4
		c1.4,0.7,2.801,1.5,4.2,2.2C677.4,364.9,693.2,372.6,708.3,381.6z" fill="#444"></path>
                    </g>
                </svg>
            </div>
            <div class="control">
                <svg version="1.1" viewBox="0 0 257.074 257.074" width="20px" height="20px"
                     transform="translate(5, 20)">
                    <g>
                        <g>
                            <path d="M178.397,170.714c-6.88-3.534-12.907-6.629-16.149-10.122l-0.357-1.905c19.253-12.109,31.452-36.251,31.452-63.034
			c0-2.105-0.108-4.179-0.291-6.225c5.295-2.771,8.465-4.85,8.866-5.119c1.838-1.226,2.945-3.291,2.945-5.504
			c0-2.213-1.107-4.276-2.945-5.504c-0.253-0.17-1.603-1.056-3.888-2.381c5.784-6.128,9.038-13.244,9.038-21.047
			c0-3.653-2.89-6.611-6.545-6.611c-3.686-0.348-16.176-10.074-24.442-16.508C159.188,13.601,141.718,0,128.536,0
			c-13.601,0-31.205,13.775-48.234,27.096c-8.515,6.662-20.181,15.79-23.686,16.165c-3.65,0-6.613,2.96-6.613,6.613
			c0,7.803,3.254,14.921,9.04,21.049c-2.284,1.325-3.633,2.211-3.886,2.381c-1.841,1.226-2.947,3.291-2.947,5.504
			s1.107,4.276,2.947,5.504c0.403,0.269,3.569,2.345,8.864,5.116c-0.183,2.046-0.291,4.12-0.291,6.227
			c0,26.781,12.199,50.925,31.456,63.034l-0.357,1.905c-3.243,3.494-9.269,6.589-16.149,10.122
			c-20.571,10.559-51.657,26.516-51.657,79.745c0,3.653,2.963,6.613,6.613,6.613h189.802c3.655,0,6.613-2.96,6.613-6.613
			C230.047,197.231,198.963,181.273,178.397,170.714z M64.021,54.556c6.093-2.828,13.744-8.685,24.431-17.044
			c13.1-10.248,31.042-24.285,40.084-24.285c8.641,0,26.43,13.85,39.421,23.964c10.995,8.562,18.849,14.54,25.083,17.392
			c-1.223,3.556-3.829,6.9-7.521,9.926c-12.139-5.522-30.056-11.787-50.524-12.922l23.395-17.126h-20.373l-9.71,5.544l-10.019-5.544
			H98.683l23.395,17.126c-20.467,1.133-38.382,7.398-50.524,12.922C67.852,61.475,65.24,58.122,64.021,54.556z M128.536,64.623
			c23.525,0,44.435,8.359,56.152,14.183c-11.718,5.826-32.629,14.183-56.152,14.183c-23.525,0-44.435-8.357-56.149-14.183
			C84.103,72.98,105.014,64.623,128.536,64.623z M122.142,243.286l5.953-18.869l0.439,0.439l0.441-0.439l5.952,18.869H122.142z
			 M128.536,206.154l-9.093-9.095l9.093-9.095l9.093,9.095L128.536,206.154z M148.973,243.846l-9.454-29.97l16.817-16.817
			l-27.799-27.797l-27.797,27.797l16.815,16.815l-9.457,29.973H40.435c2.299-39.811,25.474-51.71,44.283-61.367
			c9.029-4.636,16.828-8.639,21.596-15.038c0.6-0.805,1.01-1.739,1.195-2.727l1.545-8.22c0.544-2.892-0.884-5.791-3.507-7.12
			c-17.37-8.806-28.593-29.893-28.593-53.718c0-0.071,0.007-0.139,0.009-0.212c13.202,5.418,31.359,10.773,51.573,10.773
			c20.212,0,38.367-5.354,51.573-10.771c0,0.071,0.007,0.139,0.007,0.209c0,23.827-11.22,44.912-28.588,53.718
			c-2.621,1.331-4.052,4.23-3.509,7.12l1.545,8.22c0.185,0.988,0.595,1.922,1.197,2.727c4.766,6.399,12.565,10.405,21.596,15.038
			c18.805,9.657,41.982,21.556,44.281,61.367H148.973z" fill="#444"></path>
                        </g>
                    </g>
                </svg>
            </div>
            <div class="wc wc_up">
                WC
            </div>
            <div class="coupe">
                <div class="up">
                    <div class="sit sit_1
                        <c:if test="${call.info.get(1) != null}">
                            busy" title="${call.info.get(1)}
                        </c:if>" id="1_${i.count}_${call.numAtomic}">1
                    </div>
                    <div class="sit sit_2
                        <c:if test="${call.info.get(2) != null}">
                            busy" title="${call.info.get(2)}
                        </c:if>" id="2_${i.count}_${call.numAtomic}">2
                    </div>
                </div>
                <div class="down">
                    <div class="sit sit_3
                        <c:if test="${call.info.get(3) != null}">
                            busy" title="${call.info.get(3)}
                        </c:if>" id="3_${i.count}_${call.numAtomic}">3
                    </div>
                    <div class="sit sit_4
                        <c:if test="${call.info.get(4) != null}">
                            busy" title="${call.info.get(4)}
                        </c:if>" id="4_${i.count}_${call.numAtomic}">4
                    </div>
                </div>
            </div>
            <div class="coupe">
                <div class="up">
                    <div class="sit sit_1
                        <c:if test="${call.info.get(5) != null}">
                            busy" title="${call.info.get(5)}
                        </c:if>" id="5_${i.count}_${call.numAtomic}">5
                    </div>
                    <div class="sit sit_2
                        <c:if test="${call.info.get(6) != null}">
                            busy" title="${call.info.get(6)}
                        </c:if>" id="6_${i.count}_${call.numAtomic}">6
                    </div>
                </div>
                <div class="down">
                    <div class="sit sit_3
                        <c:if test="${call.info.get(7) != null}">
                            busy" title="${call.info.get(7)}
                        </c:if>" id="7_${i.count}_${call.numAtomic}">7
                    </div>
                    <div class="sit sit_4
                        <c:if test="${call.info.get(8) != null}">
                            busy" title="${call.info.get(8)}
                        </c:if>" id="8_${i.count}_${call.numAtomic}">8
                    </div>
                </div>
            </div>
            <div class="coupe">
                <div class="up">
                    <div class="sit sit_1
                        <c:if test="${call.info.get(9) != null}">
                            busy" title="${call.info.get(9)}
                        </c:if>" id="9_${i.count}_${call.numAtomic}">9
                    </div>
                    <div class="sit sit_2
                        <c:if test="${call.info.get(10) != null}">
                            busy" title="${call.info.get(10)}
                        </c:if>" id="10_${i.count}_${call.numAtomic}">10
                    </div>
                </div>
                <div class="down">
                    <div class="sit sit_3
                        <c:if test="${call.info.get(11) != null}">
                            busy" title="${call.info.get(11)}
                        </c:if>" id="11_${i.count}_${call.numAtomic}">11
                    </div>
                    <div class="sit sit_4
                        <c:if test="${call.info.get(12) != null}">
                            busy" title="${call.info.get(12)}
                        </c:if>" id="12_${i.count}_${call.numAtomic}">12
                    </div>
                </div>
            </div>
            <div class="coupe">
                <div class="up">
                    <div class="sit sit_1
                        <c:if test="${call.info.get(13) != null}">
                            busy" title="${call.info.get(13)}
                        </c:if>" id="13_${i.count}_${call.numAtomic}">13
                    </div>
                    <div class="sit sit_2
                        <c:if test="${call.info.get(14) != null}">
                            busy" title="${call.info.get(14)}
                        </c:if>" id="14_${i.count}_${call.numAtomic}">14
                    </div>
                </div>
                <div class="down">
                    <div class="sit sit_3
                        <c:if test="${call.info.get(15) != null}">
                            busy" title="${call.info.get(15)}
                        </c:if>" id="15_${i.count}_${call.numAtomic}">15
                    </div>
                    <div class="sit sit_4
                        <c:if test="${call.info.get(16) != null}">
                            busy" title="${call.info.get(16)}
                        </c:if>" id="16_${i.count}_${call.numAtomic}">16
                    </div>
                </div>
            </div>
            <div class="coupe">
                <div class="up">
                    <div class="sit sit_1
                        <c:if test="${call.info.get(17) != null}">
                            busy" title="${call.info.get(17)}
                        </c:if>" id="17_${i.count}_${call.numAtomic}">17
                    </div>
                    <div class="sit sit_2
                        <c:if test="${call.info.get(18) != null}">
                            busy" title="${call.info.get(18)}
                        </c:if>" id="18_${i.count}_${call.numAtomic}">18
                    </div>
                </div>
                <div class="down">
                    <div class="sit sit_3
                        <c:if test="${call.info.get(19) != null}">
                            busy" title="${call.info.get(19)}
                        </c:if>" id="19_${i.count}_${call.numAtomic}">19
                    </div>
                    <div class="sit sit_4
                        <c:if test="${call.info.get(20) != null}">
                            busy" title="${call.info.get(20)}
                        </c:if>" id="20_${i.count}_${call.numAtomic}">20
                    </div>
                </div>
            </div>
            <div class="coupe">
                <div class="up">
                    <div class="sit sit_1
                        <c:if test="${call.info.get(21) != null}">
                            busy" title="${call.info.get(21)}
                        </c:if>" id="21_${i.count}_${call.numAtomic}">21
                    </div>
                    <div class="sit sit_2
                        <c:if test="${call.info.get(22) != null}">
                            busy" title="${call.info.get(22)}
                        </c:if>" id="22_${i.count}_${call.numAtomic}">22
                    </div>
                </div>
                <div class="down">
                    <div class="sit sit_3
                        <c:if test="${call.info.get(23) != null}">
                            busy" title="${call.info.get(23)}
                        </c:if>" id="23_${i.count}_${call.numAtomic}">23
                    </div>
                    <div class="sit sit_4
                        <c:if test="${call.info.get(24) != null}">
                            busy" title="${call.info.get(24)}
                        </c:if>" id="24_${i.count}_${call.numAtomic}">24
                    </div>
                </div>
            </div>
            <div class="coupe">
                <div class="up">
                    <div class="sit sit_1
                        <c:if test="${call.info.get(25) != null}">
                            busy" title="${call.info.get(25)}
                        </c:if>" id="25_${i.count}_${call.numAtomic}">25
                    </div>
                    <div class="sit sit_2
                        <c:if test="${call.info.get(26) != null}">
                            busy" title="${call.info.get(26)}
                        </c:if>" id="26_${i.count}_${call.numAtomic}">26
                    </div>
                </div>
                <div class="down">
                    <div class="sit sit_3
                        <c:if test="${call.info.get(27) != null}">
                            busy" title="${call.info.get(27)}
                        </c:if>" id="27_${i.count}_${call.numAtomic}">27
                    </div>
                    <div class="sit sit_4
                        <c:if test="${call.info.get(28) != null}">
                            busy" title="${call.info.get(28)}
                        </c:if>" id="28_${i.count}_${call.numAtomic}">28
                    </div>
                </div>
            </div>
            <div class="coupe">
                <div class="up">
                    <div class="sit sit_1
                        <c:if test="${call.info.get(29) != null}">
                            busy" title="${call.info.get(29)}
                        </c:if>" id="29_${i.count}_${call.numAtomic}">29
                    </div>
                    <div class="sit sit_2
                        <c:if test="${call.info.get(30) != null}">
                            busy" title="${call.info.get(30)}
                        </c:if>" id="30_${i.count}_${call.numAtomic}">30
                    </div>
                </div>
                <div class="down">
                    <div class="sit sit_3
                        <c:if test="${call.info.get(31) != null}">
                            busy" title="${call.info.get(31)}
                        </c:if>" id="31_${i.count}_${call.numAtomic}">31
                    </div>
                    <div class="sit sit_4
                        <c:if test="${call.info.get(32) != null}">
                            busy" title="${call.info.get(32)}
                        </c:if>" id="32_${i.count}_${call.numAtomic}">32
                    </div>
                </div>
            </div>
            <div class="wc wc_down">
                WC
            </div>
            <div class="out">
                <svg width="20px" height="20px" viewBox="0 0 974 974" transform="translate(8, 35)">
                    <g>
                        <path d="M205.4,421.2c-11,0-20.4,8.8-20.4,19.8v94.3c0,11,9.3,19.801,20.4,19.801h229.9L301,421.2H205.4z"
                              fill="#444"></path>
                        <polygon points="654,533.8 654,421.2 541.1,421.2" fill="#444"></polygon>
                        <path d="M758.4,421.2H681v134h77.4c11,0,19.6-8.8,19.6-19.8v-94.3C778,430,769.4,421.2,758.4,421.2z"
                              fill="#444"></path>
                        <path d="M831.4,142.6C786.7,97.9,734.6,62.8,676.6,38.3C616.5,12.9,552.7,0,487,0S357.5,12.9,297.4,38.3
		c-58,24.5-110.101,59.6-154.8,104.3c-44.7,44.7-79.8,96.8-104.3,154.8C12.9,357.5,0,421.3,0,487s12.9,129.5,38.3,189.601
		c24.5,58,59.6,110.1,104.3,154.8c44.7,44.7,96.8,79.8,154.8,104.3C357.5,961.101,421.3,974,487,974s129.5-12.899,189.6-38.3
		c58-24.5,110.101-59.6,154.801-104.3c44.699-44.7,79.8-96.8,104.3-154.8C961.1,616.5,974,552.7,974,487s-12.9-129.5-38.3-189.6
		C911.2,239.4,876.1,187.4,831.4,142.6z M487,874c-103.4,0-200.6-40.2-273.7-113.3C140.3,687.5,100,590.4,100,487
		c0-86.5,28.2-168.6,80.2-236L723,793.7C655.7,845.7,573.5,874,487,874z M793.8,723L251,180.3c67.4-52,149.5-80.3,236-80.3
		c103.4,0,200.6,40.2,273.7,113.3C833.7,286.5,874,383.6,874,487C874,573.5,845.8,655.601,793.8,723z"
                              fill="#444"></path>
                        <path d="M708.3,381.6c8.8,5.3,17.3,10.9,25.4,17.4c3.2,2.601,8,1.2,9.399-2.6c0.301-0.8,0.5-1.4,0.601-1.601
		c6.7-26.3-4.5-54.7-21.7-74.6c-17.2-20-40.6-33.6-64.8-44.1c-12.7-5.5-25.7-10.4-38.601-15.3c-12-4.5-25.699-8.4-36.699-15.1
		c-3.601-2.2-8.301,0-9,4.1c-0.101,0.5-0.2,3-0.2,4c0.5,23.2,14.6,45,30.2,61.2c15.699,16.3,34.899,28.7,54.699,39.4
		c1.4,0.7,2.801,1.5,4.2,2.2C677.4,364.9,693.2,372.6,708.3,381.6z" fill="#444"></path>
                    </g>
                </svg>
            </div>
        </div>
    </c:forEach>
</div>
