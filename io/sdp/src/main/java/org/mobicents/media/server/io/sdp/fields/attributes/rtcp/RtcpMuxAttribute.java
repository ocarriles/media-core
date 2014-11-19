package org.mobicents.media.server.io.sdp.fields.attributes.rtcp;

import org.mobicents.media.server.io.sdp.fields.AttributeField;

/**
 * a=rtcp-mux
 * 
 * <p>
 * SDP attribute which indicates the desire to multiplex RTP and RTCP onto a
 * single port.<br>
 * The initial SDP offer MUST include this attribute at the media level to
 * request multiplexing of RTP and RTCP on a single port.
 * </p>
 * 
 * @author Henrique Rosa (henrique.rosa@telestax.com)
 * 
 * @see <a href="https://tools.ietf.org/html/rfc5761#section-5.1.1">RFC5761</a>
 */
public class RtcpMuxAttribute extends AttributeField {

	private static final String NAME = "rtcp-mux";

	public RtcpMuxAttribute() {
		this.key = NAME;
	}

	@Override
	protected boolean isComplex() {
		return false;
	}

}
