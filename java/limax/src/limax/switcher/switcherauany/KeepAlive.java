
package limax.switcher.switcherauany;

import limax.net.StateTransport;

// {{{ XMLGEN_IMPORT_BEGIN
// {{{ DO NOT EDIT THIS

// DO NOT EDIT THIS }}}
// XMLGEN_IMPORT_END }}}

public class KeepAlive extends limax.net.Protocol {
	@Override
	public void process() {
		((StateTransport)getTransport()).resetAlarm(milliseconds);
	}

	// {{{ XMLGEN_DEFINE_BEGIN
	// {{{ DO NOT EDIT THIS
	public static int TYPE;

	public int getType() {
		return TYPE;
	}

    public long milliseconds; 

	public KeepAlive() {
	}

	public KeepAlive(long _milliseconds_) {
		this.milliseconds = _milliseconds_;
	}

	@Override
	public limax.codec.OctetsStream marshal(limax.codec.OctetsStream _os_) {
		_os_.marshal(this.milliseconds);
		return _os_;
	}

	@Override
	public limax.codec.OctetsStream unmarshal(limax.codec.OctetsStream _os_) throws limax.codec.MarshalException {
		this.milliseconds = _os_.unmarshal_long();
		return _os_;
	}

	@Override
	public String toString() {
		StringBuilder _sb_ = new StringBuilder(super.toString());
		_sb_.append("=(");
		_sb_.append(this.milliseconds).append(",");
		_sb_.append(")");
		return _sb_.toString();
	}

	// DO NOT EDIT THIS }}}
	// XMLGEN_DEFINE_END }}}

}

