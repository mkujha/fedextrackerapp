package com.demo;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.demo.domain.Address;
import com.demo.domain.AvailableImagesDetail;
import com.demo.domain.CarrierCodeType;
import com.demo.domain.Commodity;
import com.demo.domain.CompletedTrackDetail;
import com.demo.domain.Contact;
import com.demo.domain.ContactAndAddress;
import com.demo.domain.ContentRecord;
import com.demo.domain.CustomerExceptionRequestDetail;
import com.demo.domain.CustomsOptionDetail;
import com.demo.domain.DeliveryOptionEligibilityDetail;
import com.demo.domain.Dimensions;
import com.demo.domain.Distance;
import com.demo.domain.FedExLocationType;
import com.demo.domain.Notification;
import com.demo.domain.NotificationEventType;
import com.demo.domain.NotificationSeverityType;
import com.demo.domain.OfficeOrderDeliveryMethodType;
import com.demo.domain.OperatingCompanyType;
import com.demo.domain.PackagingType;
import com.demo.domain.PhysicalPackagingType;
import com.demo.domain.PieceCountVerificationDetail;
import com.demo.domain.SignatureImageDetail;
import com.demo.domain.TrackAdvanceNotificationDetail;
import com.demo.domain.TrackChargeDetail;
import com.demo.domain.TrackDeliveryLocationType;
import com.demo.domain.TrackDetail;
import com.demo.domain.TrackDetailAttributeType;
import com.demo.domain.TrackEvent;
import com.demo.domain.TrackInformationNoteDetail;
import com.demo.domain.TrackOtherIdentifierDetail;
import com.demo.domain.TrackPayment;
import com.demo.domain.TrackPossessionStatusType;
import com.demo.domain.TrackReconciliation;
import com.demo.domain.TrackReturnDetail;
import com.demo.domain.TrackServiceDescriptionDetail;
import com.demo.domain.TrackSpecialHandling;
import com.demo.domain.TrackSpecialInstruction;
import com.demo.domain.TrackSplitShipmentPart;
import com.demo.domain.TrackStatusDetail;
import com.demo.domain.TrackingDateOrTimestamp;
import com.demo.domain.TransactionDetail;
import com.demo.domain.VersionId;
import com.demo.domain.Weight;
import com.demo.domain.WriteEventLogResponse;
import com.demo.fedex.domain.TrackReply;

@Mapper
public interface TrackerMapper {
	TrackerMapper INSTANCE = Mappers.getMapper(TrackerMapper.class);

	NotificationSeverityType map(com.demo.fedex.domain.NotificationSeverityType reply);

	Notification map(com.demo.fedex.domain.Notification reply);

	TransactionDetail map(com.demo.fedex.domain.TransactionDetail reply);

	VersionId map(com.demo.fedex.domain.VersionId reply);

	List<Notification> map(List<com.demo.fedex.domain.Notification> reply);

	List<CompletedTrackDetail> map1(List<com.demo.fedex.domain.CompletedTrackDetail> value);

	CompletedTrackDetail map(com.demo.fedex.domain.CompletedTrackDetail value);

	List<TrackDetail> map3(List<com.demo.fedex.domain.TrackDetail> value);

	TrackDetail map(com.demo.fedex.domain.TrackDetail reply);

	TrackStatusDetail map(com.demo.fedex.domain.TrackStatusDetail reply);

	List<TrackInformationNoteDetail> map4(List<com.demo.fedex.domain.TrackInformationNoteDetail> value);

	TrackInformationNoteDetail map(com.demo.fedex.domain.TrackInformationNoteDetail value);

	List<CustomerExceptionRequestDetail> map5(List<com.demo.fedex.domain.CustomerExceptionRequestDetail> value);

	CustomerExceptionRequestDetail map(com.demo.fedex.domain.CustomerExceptionRequestDetail value);

	TrackReconciliation map(com.demo.fedex.domain.TrackReconciliation value);

	CarrierCodeType map(com.demo.fedex.domain.CarrierCodeType value);

	OperatingCompanyType map(com.demo.fedex.domain.OperatingCompanyType value);

	ContactAndAddress map(com.demo.fedex.domain.ContactAndAddress value);

	List<TrackOtherIdentifierDetail> map6(List<com.demo.fedex.domain.TrackOtherIdentifierDetail> value);

	TrackOtherIdentifierDetail map(com.demo.fedex.domain.TrackOtherIdentifierDetail value);

	TrackServiceDescriptionDetail map(com.demo.fedex.domain.TrackServiceDescriptionDetail value);

	Weight map(com.demo.fedex.domain.Weight value);

	Dimensions map(com.demo.fedex.domain.Dimensions value);

	PackagingType map(com.demo.fedex.domain.PackagingType value);

	PhysicalPackagingType map(com.demo.fedex.domain.PhysicalPackagingType value);

	List<TrackChargeDetail> map7(List<com.demo.fedex.domain.TrackChargeDetail> value);

	TrackChargeDetail map(com.demo.fedex.domain.TrackChargeDetail value);

	List<TrackDetailAttributeType> map8(List<com.demo.fedex.domain.TrackDetailAttributeType> value);

	ContentRecord map(com.demo.fedex.domain.ContentRecord value);

	List<ContentRecord> map9(List<com.demo.fedex.domain.ContentRecord> value);

	String map(String value);

	List<String> map10(List<String> value);

	TrackReturnDetail map(com.demo.fedex.domain.TrackReturnDetail value);

	Commodity map(com.demo.fedex.domain.Commodity value);

	List<Commodity> map11(List<com.demo.fedex.domain.Commodity> value);

	CustomsOptionDetail map(com.demo.fedex.domain.CustomsOptionDetail value);

	List<CustomsOptionDetail> map12(List<com.demo.fedex.domain.CustomsOptionDetail> value);

	TrackAdvanceNotificationDetail map(com.demo.fedex.domain.TrackAdvanceNotificationDetail value);

	List<TrackSpecialHandling> map13(List<com.demo.fedex.domain.TrackSpecialHandling> value);

	TrackSpecialHandling map(com.demo.fedex.domain.TrackSpecialHandling value);

	List<TrackPayment> map14(List<com.demo.fedex.domain.TrackPayment> value);

	TrackPayment map(com.demo.fedex.domain.TrackPayment value);

	Contact map(com.demo.fedex.domain.Contact value);

	TrackPossessionStatusType map(com.demo.fedex.domain.TrackPossessionStatusType value);

	Address map(com.demo.fedex.domain.Address value);

	List<TrackingDateOrTimestamp> map15(List<com.demo.fedex.domain.TrackingDateOrTimestamp> value);

	TrackingDateOrTimestamp map(com.demo.fedex.domain.TrackingDateOrTimestamp value);

	Distance map(com.demo.fedex.domain.Distance value);

	List<TrackSpecialInstruction> map16(List<com.demo.fedex.domain.TrackSpecialInstruction> value);

	TrackSpecialInstruction map(com.demo.fedex.domain.TrackSpecialInstruction value);

	FedExLocationType map(com.demo.fedex.domain.FedExLocationType value);

	OfficeOrderDeliveryMethodType map(com.demo.fedex.domain.OfficeOrderDeliveryMethodType value);

	TrackDeliveryLocationType map(com.demo.fedex.domain.TrackDeliveryLocationType value);

	List<PieceCountVerificationDetail> map17(List<com.demo.fedex.domain.PieceCountVerificationDetail> value);

	PieceCountVerificationDetail map(com.demo.fedex.domain.PieceCountVerificationDetail value);

	List<AvailableImagesDetail> map18(List<com.demo.fedex.domain.AvailableImagesDetail> value);

	AvailableImagesDetail map(com.demo.fedex.domain.AvailableImagesDetail value);

	SignatureImageDetail map(com.demo.fedex.domain.SignatureImageDetail value);

	NotificationEventType map(com.demo.fedex.domain.NotificationEventType value);

	List<TrackSplitShipmentPart> map20(List<com.demo.fedex.domain.TrackSplitShipmentPart> value);

	TrackSplitShipmentPart map(com.demo.fedex.domain.TrackSplitShipmentPart value);

	List<NotificationEventType> map19(List<com.demo.fedex.domain.NotificationEventType> value);

	DeliveryOptionEligibilityDetail map(com.demo.fedex.domain.DeliveryOptionEligibilityDetail value);

	List<DeliveryOptionEligibilityDetail> map21(List<com.demo.fedex.domain.DeliveryOptionEligibilityDetail> value);

	List<TrackEvent> map22(List<com.demo.fedex.domain.TrackEvent> value);

	TrackEvent map(com.demo.fedex.domain.TrackEvent value);

	java.util.List<com.demo.domain.NotificationParameter> map23(
			java.util.List<com.demo.fedex.domain.NotificationParameter> value);

	com.demo.domain.Localization map(com.demo.fedex.domain.Localization value);

	com.demo.domain.StringBarcode map(com.demo.fedex.domain.StringBarcode value);

	java.util.List<com.demo.domain.TrackStatusAncillaryDetail> map24(
			java.util.List<com.demo.fedex.domain.TrackStatusAncillaryDetail> value);

	com.demo.domain.TrackPackageIdentifier map(com.demo.fedex.domain.TrackPackageIdentifier value);

	com.demo.domain.ServiceType map(com.demo.fedex.domain.ServiceType value);

	com.demo.domain.WeightUnits map(com.demo.fedex.domain.WeightUnits value);

	com.demo.domain.LinearUnits map(com.demo.fedex.domain.LinearUnits value);

	com.demo.domain.TrackChargeDetailType map(com.demo.fedex.domain.TrackChargeDetailType value);

	com.demo.domain.TrackDetailAttributeType map(com.demo.fedex.domain.TrackDetailAttributeType value);

	com.demo.domain.TrackReturnMovementStatusType map(com.demo.fedex.domain.TrackReturnMovementStatusType value);

	com.demo.domain.CommodityPurposeType map(com.demo.fedex.domain.CommodityPurposeType value);

	com.demo.domain.CustomsOptionType map(com.demo.fedex.domain.CustomsOptionType value);

	com.demo.domain.TrackAdvanceNotificationStatusType map(
			com.demo.fedex.domain.TrackAdvanceNotificationStatusType value);

	com.demo.domain.TrackSpecialHandlingType map(com.demo.fedex.domain.TrackSpecialHandlingType value);

	com.demo.domain.Money map(com.demo.fedex.domain.Money value);

	com.demo.domain.TrackReturnLabelType map(com.demo.fedex.domain.TrackReturnLabelType value);

	com.demo.domain.TrackPaymentType map(com.demo.fedex.domain.TrackPaymentType value);

	com.demo.domain.TrackChargesPaymentClassificationType map(
			com.demo.fedex.domain.TrackChargesPaymentClassificationType value);

	com.demo.domain.TrackingDateOrTimestampType map(com.demo.fedex.domain.TrackingDateOrTimestampType value);

	com.demo.domain.DistanceUnits map(com.demo.fedex.domain.DistanceUnits value);

	com.demo.domain.TrackDeliveryOptionType map(com.demo.fedex.domain.TrackDeliveryOptionType value);

	com.demo.domain.PieceCountLocationType map(com.demo.fedex.domain.PieceCountLocationType value);

	com.demo.domain.AvailableImageType map(com.demo.fedex.domain.AvailableImageType value);

	com.demo.domain.DeliveryOptionType map(com.demo.fedex.domain.DeliveryOptionType value);

	com.demo.domain.ArrivalLocationType map(com.demo.fedex.domain.ArrivalLocationType value);

	com.demo.domain.NotificationParameter map(com.demo.fedex.domain.NotificationParameter value);

	com.demo.domain.StringBarcodeType map(com.demo.fedex.domain.StringBarcodeType value);

	com.demo.domain.TrackStatusAncillaryDetail map(com.demo.fedex.domain.TrackStatusAncillaryDetail value);

	com.demo.domain.TrackIdentifierType map(com.demo.fedex.domain.TrackIdentifierType value);

	com.demo.domain.NaftaCommodityDetail map(com.demo.fedex.domain.NaftaCommodityDetail value);

	com.demo.domain.SpecialInstructionStatusDetail map(com.demo.fedex.domain.SpecialInstructionStatusDetail value);

	com.demo.domain.ImageSizeType map(com.demo.fedex.domain.ImageSizeType value);

	com.demo.domain.EligibilityType map(com.demo.fedex.domain.EligibilityType value);

	java.util.List<com.demo.domain.Measure> map27(java.util.List<com.demo.fedex.domain.Measure> value);

	com.demo.domain.Measure map(com.demo.fedex.domain.Measure value);

	com.demo.domain.AppointmentDetail map(com.demo.fedex.domain.AppointmentDetail value);

	com.demo.domain.NaftaPreferenceCriterionCode map(com.demo.fedex.domain.NaftaPreferenceCriterionCode value);

	com.demo.domain.SpecialInstructionsStatusCode map(com.demo.fedex.domain.SpecialInstructionsStatusCode value);

	java.util.List<com.demo.domain.EdtExciseCondition> map28(
			java.util.List<com.demo.fedex.domain.EdtExciseCondition> value);

	com.demo.domain.EdtExciseCondition map(com.demo.fedex.domain.EdtExciseCondition value);

	com.demo.domain.NaftaProducerDeterminationCode map(com.demo.fedex.domain.NaftaProducerDeterminationCode value);

	java.util.List<com.demo.domain.AppointmentTimeDetail> map29(
			java.util.List<com.demo.fedex.domain.AppointmentTimeDetail> value);

	com.demo.domain.AppointmentTimeDetail map(com.demo.fedex.domain.AppointmentTimeDetail value);

	com.demo.domain.NaftaNetCostMethodCode map(com.demo.fedex.domain.NaftaNetCostMethodCode value);

	com.demo.domain.AppointmentWindowType map(com.demo.fedex.domain.AppointmentWindowType value);

	com.demo.domain.DateRange map(com.demo.fedex.domain.DateRange value);

	com.demo.domain.LocalTimeRange map(com.demo.fedex.domain.LocalTimeRange value);

	WriteEventLogResponse map(TrackReply reply);

}